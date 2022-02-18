package myaws.s3;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

//    private static final String AWS_ACCESS_KEY = "AWS_ACCESS_KEY_ID";
//    private static final String AWS_SECRET_ACCESS_KEY = "AWS_SECRET_ACCESS_KEY";
    private static final String BUCKET_NAME = "sdfgfghgffgytyv";
    private static final String FILE_NAME1 = "example.txt";
    private static final String FILE_NAME2 = "newname.txt";
    private static final String FILE_NAME3 = "downlodedFile.txt";
    private static final URL FILE_URL = Application.class.getClassLoader().getResource(FILE_NAME1);
    //private static final String DOWNLOADED_FILE_URL = Application.class.getClassLoader().getName();

    private final AmazonS3Client s3Client;

    public Application(AmazonS3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void createBucket(String bucketName){
        try {
            CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
            s3Client.createBucket(createBucketRequest);
        } catch (Exception e) {
            log.error("Error in createBucket", e);
        }
    }

    public void uploadFile(String bucketName, String key, File file){
        try {
            PutObjectRequest putBucketRequest = new PutObjectRequest(bucketName, key, file);
            s3Client.putObject(putBucketRequest);
        } catch (Exception e) {
            log.error("Error in uploadFile", e);
        }
    }

    public void downloadFile(String bucketName, String key, File downloadedFile) {
        try {
            GetObjectRequest getBucketRequest = new GetObjectRequest(bucketName, key);
            s3Client.getObject(getBucketRequest, downloadedFile);
        } catch (Exception e) {
            log.error("Error in downloadFile", e);
        }
    }

    public List<String> listFiles(String bucketName) {
        List<String> keys = new ArrayList<>();
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        ObjectListing objectListing = s3Client.listObjects(listObjectsRequest);
        return objectListing.getObjectSummaries().stream()
            .map(S3ObjectSummary::getKey)
            .collect(Collectors.toList());
    }

    public List<String> listBuckets() {
        List<String> keys = new ArrayList<>();
        return s3Client.listBuckets().stream()
            .map(Bucket::getName)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) throws URISyntaxException {
        String region = Regions.EU_CENTRAL_1.getName();

//        String accessKey = System.getenv(AWS_ACCESS_KEY);
//        String secretKey = System.getenv(AWS_SECRET_ACCESS_KEY);

        AmazonS3Client amazonS3Client = (AmazonS3Client) AmazonS3Client.builder()
            .withRegion(region)
            .withCredentials(new EnvironmentVariableCredentialsProvider())
            .build();

        Application app = new Application(amazonS3Client);
        //app.createBucket(BUCKET_NAME);

//        File file = new File(FILE_URL.toURI());
//        app.uploadFile(BUCKET_NAME, FILE_NAME2, file);

       // log.info("dff",FILE_URL.getPath() );

       // app.downloadFile(BUCKET_NAME, FILE_NAME2, new File(FILE_URL.getPath()+".downloaded"));

        System.out.println("BUCKETS");
        System.out.println(app.listBuckets());
        System.out.println("FILES");
        System.out.println(app.listFiles(BUCKET_NAME));

    }
}
