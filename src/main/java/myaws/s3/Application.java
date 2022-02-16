package myaws.s3;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CreateBucketRequest;

public class Application {

//    private static final String AWS_ACCESS_KEY = "AWS_ACCESS_KEY_ID";
//    private static final String AWS_SECRET_ACCESS_KEY = "AWS_SECRET_ACCESS_KEY";
    private static final String BUCKET_NAME = "sdfgfghgffgytyv";

    private final AmazonS3Client s3Client;

    public Application(AmazonS3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void createBucket(String name){
        try {
            CreateBucketRequest createBucketRequest = new CreateBucketRequest(name);
            s3Client.createBucket(createBucketRequest);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        String region = Regions.EU_CENTRAL_1.getName();

//        String accessKey = System.getenv(AWS_ACCESS_KEY);
//        String secretKey = System.getenv(AWS_SECRET_ACCESS_KEY);

        AmazonS3Client amazonS3Client = (AmazonS3Client) AmazonS3Client.builder()
            .withRegion(region)
            .withCredentials(new EnvironmentVariableCredentialsProvider())
            .build();

        Application app = new Application(amazonS3Client);
        app.createBucket(BUCKET_NAME);
    }
}
