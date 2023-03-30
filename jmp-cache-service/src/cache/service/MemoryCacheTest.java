package cache.service;

public class MemoryCacheTest {

        public static void main(String[] args) throws InterruptedException {
            MemoryCacheTest cache = new MemoryCacheTest();

//            printActivity("\n\n==========Test1: crunchifyTestAddRemoveObjects ==========");
//            cache.testAddRemoveObjects();
//
//            printActivity("\n\n==========Test2: crunchifyTestExpiredCacheObjects ==========");
//            cache.testExpiredCacheObjects();

            printActivity("\n\n==========Test3: crunchifyTestObjectsCleanupTime ==========");
            cache.testObjectsCleanupTime();
        }
        private void testAddRemoveObjects() {
           MemoryInCache<String, String> cache = new MemoryInCache<String, String>(200, 500, 6);
            cache.put("eBay", "eBay");
            cache.put("Paypal", "Paypal");
            cache.put("Google", "Google");
            cache.put("Microsoft", "Microsoft");
            cache.put("Crunchify", "Crunchify");
            cache.put("Facebook", "Facebook");

            printActivity("6 Cache Object Added.. cache.size(): " + cache.size());
            cache.remove("IBM");
            printActivity("One object removed.. cache.size(): " + cache.size());
            cache.put("Twitter", "Twitter");
            cache.put("SAP", "SAP");
            printActivity("Two objects Added but reached maxItems.. cache.size(): " + cache.size());
        }

        private static void printActivity(String s) {

            System.out.println(s);
        }

        private void testExpiredCacheObjects() throws InterruptedException {
            MemoryInCache<String, String> cache = new MemoryInCache<String, String>(1, 1, 10);
            cache.put("eBay", "eBay");
            cache.put("Paypal", "Paypal");
            Thread.sleep(3000);
            printActivity("Two objects are added but reached timeToLive. cache.size(): " + cache.size());
        }
        private void testObjectsCleanupTime() throws InterruptedException {
            int size = 500000;
            MemoryInCache<String, String> cache = new MemoryInCache<String, String>(100, 100, 500000);
            for (int i = 0; i < size; i++) {
                String value = Integer.toString(i);
                cache.put(value, value);
            }
            Thread.sleep(200);
            long start = System.currentTimeMillis();
            cache.cleanup();
            double finish = (double) (System.currentTimeMillis() - start) / 1000.0;

            printActivity("Cleanup times for " + size + " objects are " + finish + " s");
        }
    }

