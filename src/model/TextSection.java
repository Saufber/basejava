package model;

import java.util.Objects;

public class TextSection extends Section{
    private static final long serialVersionUID =1L;

    private final String content;

    public TextSection(String content) {
        this.content = content;
    }

    public String getContent() {
        Objects.requireNonNull(content, "content must not be null");
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public String toString() {
        return content;
    }
}
