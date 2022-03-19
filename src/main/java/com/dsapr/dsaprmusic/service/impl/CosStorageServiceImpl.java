package com.dsapr.dsaprmusic.service.impl;

import com.dsapr.dsaprmusic.dto.FileUploadDto;
import com.dsapr.dsaprmusic.exception.BizException;
import com.dsapr.dsaprmusic.exception.ExceptionType;
import com.dsapr.dsaprmusic.service.StorageService;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.TreeMap;

@Service("COS")
public class CosStorageServiceImpl implements StorageService {

    @Value("${cos.bucket}")
    private String bucket;

    @Value("${cos.secret-id}")
    private String secretId;

    @Value("${cos.secret-key}")
    private String secretKey;

    @Value("${cos.region}")
    private String region;

    @Override
    public FileUploadDto initFileUpload() {
        FileUploadDto fileUploadDto = new FileUploadDto();
        try {
            Response response = CosStsClient.getCredential(getCosStsConfig());
            fileUploadDto.setBucket(bucket);
            fileUploadDto.setRegion(region);
            fileUploadDto.setSecretId(response.credentials.tmpSecretId);
            fileUploadDto.setSecretKey(response.credentials.tmpSecretKey);
            fileUploadDto.setSessionToken(response.credentials.sessionToken);
            return fileUploadDto;
        } catch (IOException e) {
            e.printStackTrace();
            throw new BizException(ExceptionType.INNER_ERROR);
        }
    }

    private TreeMap<String, Object> getCosStsConfig() {
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        config.put("secretId", secretId);
        config.put("secretKey", secretKey);

        // 临时密钥有效时长，单位是秒
        config.put("durationSeconds", 1800);
        config.put("allowPrefixes", new String[]{
                "*"
        });
        config.put("bucket", bucket);
        config.put("region", region);
        String[] allowActions = new String[]{
                // 简单上传
                "name/cos:PutObject",
                "name/cos:PostObject",
                // 分片上传
                "name/cos:InitiateMultipartUpload",
                "name/cos:ListMultipartUploads",
                "name/cos:ListParts",
                "name/cos:UploadPart",
                "name/cos:CompleteMultipartUpload"
        };
        config.put("allowActions", allowActions);
        return config;
    }

    // Todo: 改造client获取方法
//    COSClient createCOSClient() {
//        // 这里需要已经获取到临时密钥的结果。
//        // 临时密钥的生成参考 https://cloud.tencent.com/document/product/436/14048#cos-sts-sdk
//
//        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
//
//        // ClientConfig 中包含了后续请求 COS 的客户端设置：
//        ClientConfig clientConfig = new ClientConfig();
//
//        // 设置 bucket 的地域
//        // COS_REGION 请参照 https://cloud.tencent.com/document/product/436/6224
//        clientConfig.setRegion(new Region(region));
//
//        // 设置请求协议, http 或者 https
//        // 5.6.53 及更低的版本，建议设置使用 https 协议
//        // 5.6.54 及更高版本，默认使用了 https
//        clientConfig.setHttpProtocol(HttpProtocol.https);
//
//        // 以下的设置，是可选的：
//
//        // 设置 socket 读取超时，默认 30s
//        clientConfig.setSocketTimeout(30 * 1000);
//        // 设置建立连接超时，默认 30s
//        clientConfig.setConnectionTimeout(30 * 1000);
//
//        return new COSClient(cred, clientConfig);
//    }

}
