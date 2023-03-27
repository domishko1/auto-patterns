package proxyPattern.objects;

import java.util.HashMap;

public class SiteProxy implements SourceInfo {
    private SourceInfo sourceInfo;
    private HashMap<String, String> cache;

    public SiteProxy(SourceInfo sourceInfo) {
        this.sourceInfo = sourceInfo;
        cache = new HashMap<>();
    }

    @Override
    public String getSource(String pageName) {
        String source;
        if (cache.containsKey(pageName)) {
            source = cache.get(pageName);
            source = "from cache:" + source;
        } else {
            source = sourceInfo.getSource(pageName);
            cache.put(pageName, source);
        }

        System.out.println(source);
        return source;
    }
}
