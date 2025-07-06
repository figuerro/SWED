// Strategie 1: Content Size

public class ContentSizeStrategy implements ComparisonStrategy {
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        return oldContent.length() != newContent.length();
    }
}