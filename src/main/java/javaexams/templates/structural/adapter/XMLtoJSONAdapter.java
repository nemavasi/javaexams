package javaexams.templates.structural.adapter;

public class XMLtoJSONAdapter implements IJsonContent{

    private XMLData data;

    public XMLtoJSONAdapter(XMLData data) {
        this.data = data;
    }

    private String convertToJSON(){
        return data.getXmlCotent() + " converted to json";
    }

    @Override
    public String getJsonContent() {
        return convertToJSON();
    }
}
