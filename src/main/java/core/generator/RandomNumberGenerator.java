package core.generator;

import java.security.SecureRandom;

public class RandomNumberGenerator {

   private SecureRandom secureRandom = new SecureRandom();

    public long getRandomLongInRange(long min, long max) {
        return secureRandom.longs(min, (max + 1)).limit(1).findFirst().getAsLong();

    }
}
