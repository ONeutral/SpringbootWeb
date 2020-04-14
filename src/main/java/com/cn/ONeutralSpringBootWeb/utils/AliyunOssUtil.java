package com.cn.ONeutralSpringBootWeb.utils;

import com.cn.ONeutralSpringBootWeb.constant.AliyunOssConfigConstant;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**阿里云OSS上传工具类
 */
@Component
public class AliyunOssUtil {
    private static  final Logger logger = LoggerFactory.getLogger(AliyunOssUtil.class);
    private static String bucketName = AliyunOssConfigConstant.BUCKE_NAME;
    private static String endPoint = AliyunOssConfigConstant.END_POINT;
    private static String accessKeyId = AliyunOssConfigConstant.ACCESSKEY_ID;
    private static String accessKeySecret = AliyunOssConfigConstant.ACCESSKEY_SECRET;
    private static String fileHost = AliyunOssConfigConstant.FILE_HOST;

    private String fileUrl1;

    public  String upLoad(File file){
        boolean isImage = true;
        try {
            Image image = ImageIO.read(file);
            isImage = image == null?false:true;
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("----文件上传开始----"+file.getName());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());

        if(file == null){
            return null;
        }

        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);

        //OSSClient ossClient = new OSSClient(endPoint,accessKeyId ,accessKeySecret );
        try {
            if(!ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //设置文件路径
            String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "")+"-"+file.getName());
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            if(isImage){
                fileUrl1 = "https://" + bucketName + "." + endPoint + "/" + fileUrl;
            }else {
                fileUrl = "非图片，不可预览。文件路径为：" + fileUrl;
            }
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
            if(result != null){
                logger.info("-----OSS文件上传成功-----"+fileUrl);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ossClient != null){
                ossClient.shutdown();
            }
        }
        return fileUrl1;
    }
}
