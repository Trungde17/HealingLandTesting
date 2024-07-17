import java.util.logging.Logger;

public class MathUtils {
    public static int checkOpNumber(int n, String op) {
        Logger logger = Logger.getLogger(MathUtils.class.getName());
        if (op == null) {
            logger.warning("Error, operation cannot be null");
            return -1;
        }
        switch (op) {
            case "Perfect":
                int sum = 0;
                for (int i = 1; i < n; i++) {
                    if (n % i == 0) {
                        sum += i;
                    }
                }
                if (sum == n) {
                    logger.info("Perfect number: " + n);
                    return 1;
                } else {
                    logger.info(n + " is not a perfect number");
                    return 0;
                }
            case "Square":
                int sqr = (int) Math.sqrt(n);
                if (sqr * sqr == n) {
                    logger.info("Square number: " + n);
                    return 1;
                } else {
                    logger.info(n + " is not a square number");
                    return 0;
                }
            default:
                logger.warning("Error, unsupported operation");
                return -1;
        }
    }
}
