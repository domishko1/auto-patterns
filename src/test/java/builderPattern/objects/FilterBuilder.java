package builderPattern.objects;

public interface FilterBuilder {

    public FilterBuilder setSection(String section);

    public FilterBuilder setCountry(String country);

    public Filter build();
}
