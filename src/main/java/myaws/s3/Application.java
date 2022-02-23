package myaws.s3;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.signer.Presigner;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.CopyObjectRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.PublicAccessBlockConfiguration;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutPublicAccessBlockRequest;
import software.amazon.awssdk.services.s3.model.S3Object;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    //    private static final String AWS_ACCESS_KEY = "AWS_ACCESS_KEY_ID";
//    private static final String AWS_SECRET_ACCESS_KEY = "AWS_SECRET_ACCESS_KEY";
    private static final String BUCKET_NAME = "sdfgfghgffgytyv";
    private static final String BUCKET_NAME_FOR_COPY = "dfxghjghjdghjdghj";
    private static final String BUCKET_NAME_FOR_DELETE = "dgfdfghfghfghfghghgh";
    private static final String FILE_NAME1 = "example.txt";
    private static final String FILE_NAME2 = "newname.txt";
    private static final String FILE_NAME3 = "downlodedFile.txt";
    private static final URL FILE_URL = Application.class.getClassLoader().getResource(FILE_NAME1);
    //private static final String DOWNLOADED_FILE_URL = Application.class.getClassLoader().getName();

    private final S3Client s3Client;
    private final S3Presigner s3Presigner;

    public Application(S3Client s3Client, S3Presigner s3Presigner) {
        this.s3Client = s3Client;
        this.s3Presigner = s3Presigner;
    }

    public void createBucket(String bucketName) {
        try {
            CreateBucketRequest createBucketRequest = CreateBucketRequest.builder()
                .bucket(bucketName)
                .build();
            s3Client.createBucket(createBucketRequest);
        } catch (Exception e) {
            log.error("Error in createBucket", e);
        }
    }

    public void uploadFile(String bucketName, String key, URI uri) {
        try {
            PutObjectRequest putBucketRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
            s3Client.putObject(putBucketRequest, Path.of(uri));
        } catch (Exception e) {
            log.error("Error in uploadFile", e);
        }
    }

    public void downloadFile(String bucketName, String key, URI uri) {
        try {
            GetObjectRequest getBucketRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
            s3Client.getObject(getBucketRequest, Path.of(uri));
        } catch (Exception e) {
            log.error("Error in downloadFile", e);
        }
    }

    public List<String> listFiles(String bucketName) {
        List<String> keys = new ArrayList<>();
        ListObjectsRequest listObjectsRequest = ListObjectsRequest.builder()
            .bucket(bucketName)
            .build();

        ListObjectsResponse objectListing = s3Client.listObjects(listObjectsRequest);
        return objectListing.contents().stream()
            .map(S3Object::key)
            .collect(Collectors.toList());
    }

    public List<String> listBuckets() {
        return s3Client.listBuckets().buckets().stream()
            .map(Bucket::name)
            .collect(Collectors.toList());
    }

    public void copyFile(String sourceBucketName, String sourceKey, String destinationBucketName,
                         String destinationKey) {
        try {
            String encodedSourceUrl = URLEncoder.encode(sourceBucketName + "/" + sourceKey, StandardCharsets.UTF_8);
            CopyObjectRequest copyObjectRequest = CopyObjectRequest.builder()
                .copySource(encodedSourceUrl)
                .destinationBucket(destinationBucketName)
                .destinationKey(destinationKey)
                .build();

            s3Client.copyObject(copyObjectRequest);

        } catch (Exception e) {
            log.error("Error in copyFile", e);
        }
    }

    public void blockBucket(String bucketName) {
        try {
            PutPublicAccessBlockRequest putPublicAccessBlockRequest = PutPublicAccessBlockRequest.builder()
                .bucket(bucketName)
                .publicAccessBlockConfiguration(PublicAccessBlockConfiguration.builder()
                    .blockPublicAcls(true)
                    .blockPublicPolicy(true)
                    .restrictPublicBuckets(true)
                    .ignorePublicAcls(true)
                    .build())
                .build();

            s3Client.putPublicAccessBlock(putPublicAccessBlockRequest);

        } catch (Exception e) {
            log.error("Error in uploadFile", e);
        }
    }

    public String resolvePreSignedUrl(String bucketName, String key) {
        try {
            GetObjectRequest getBucketRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
            GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
                .getObjectRequest(getBucketRequest)
                .signatureDuration(Duration.ofSeconds(30))
                .build();

            return s3Presigner.presignGetObject(getObjectPresignRequest).url().toString();

        } catch (Exception e) {
            log.error("Error in resolvePreSignedUrl", e);
        }
        return null;
    }

    public void deleteBucket(String bucketName) {
        try {
            DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder()
                .bucket(bucketName)
                .build();

            s3Client.deleteBucket(deleteBucketRequest);
        } catch (Exception e) {
          log.error("Error in deleteBucket", e);
        }
    }

    public static void main(String[] args) throws URISyntaxException {

//        String accessKey = System.getenv(AWS_ACCESS_KEY);
//        String secretKey = System.getenv(AWS_SECRET_ACCESS_KEY);

        S3Client amazonS3Client = S3Client.builder()
            .region(Region.EU_CENTRAL_1)
            .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
            .build();
        S3Presigner presigner = S3Presigner.builder()
            .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
            .build();

        Application app = new Application(amazonS3Client, presigner);
//        app.createBucket(BUCKET_NAME);

        //       app.uploadFile(BUCKET_NAME, FILE_NAME2, FILE_URL.toURI());

        // log.info("dff",FILE_URL.getPath() );

        //app.downloadFile(BUCKET_NAME, FILE_NAME2, Path.of(FILE_URL.getPath()+".downloaded").toUri());

//        System.out.println("BUCKETS");
//        System.out.println(app.listBuckets());
//        System.out.println("FILES");
//        System.out.println(app.listFiles(BUCKET_NAME));

        //  app.copyFile(BUCKET_NAME, FILE_NAME2, BUCKET_NAME_FOR_COPY, FILE_NAME2);

        // app.blockBucket(BUCKET_NAME);
        //System.out.println(app.resolvePreSignedUrl(BUCKET_NAME_FOR_COPY, FILE_NAME2));
        app.deleteBucket(BUCKET_NAME_FOR_DELETE);
        System.out.println(app.listBuckets());
    }
}
