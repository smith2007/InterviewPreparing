package bfs;

public class WebCrawlerMultithreaded {
/*
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        ConcurrentHashMap<String, String> visited = new ConcurrentHashMap<>();


    }

    private void dive(String currUrl, HtmlParser parser, ConcurrentHashMap<String, String> visited) {

        if (visited.containsKey(currUrl)) {
            return;
        }

    //    visited.putIfAbsent(currUrl);

        List<String> urls = parser.getUrls(currUrl);


        for (String url : urls) {
            Runnable runnable = () -> {
                    dive(url,parser, visited);
            };
            runnable.run();
        }


    }


    interface HtmlParser {
        // Return a list of all urls from a webpage of given url.
        // This is a blocking call, that means it will do HTTP request and return when this request is finished.
        public List<String> getUrls(String url);
    }*/
}
