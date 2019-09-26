import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import router.DestinyInfoRoute;
import spark.Spark;

@SuppressWarnings("PMD.UseUtilityClass")
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DestinyInfoRoute.class
})
public class ApiTest {

    @BeforeClass
    public static void beforeSuite() {
        Spark.port(8080);
        new Router().init();
        Spark.awaitInitialization();
    }

    @AfterClass
    public static void afterSuite() {
        Spark.stop();
    }
}
