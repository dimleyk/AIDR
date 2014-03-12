package qa.qcri.aidr.output.filter;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
@JsonTypeInfo(  
	    use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "query_type")  
	@JsonSubTypes({  
		@JsonSubTypes.Type(value = DateQueryJsonObject.class, name = "date_query"),  
		@JsonSubTypes.Type(value = ClassifierQueryJsonObject.class, name = "classifier_query") })
 */  
@SuppressWarnings("serial")
@XmlRootElement(name="QueryJsonObject")
public abstract class QueryJsonObject implements Serializable {
	@XmlElement public QueryType queryType;
	@XmlElement public ComparatorType comparator;
	@XmlElement public String time;


	@XmlElement public String classifier_code;		// corresponds to "attribute_code" in nominal_attributes object	
	@XmlElement public String label_code;			// corresponds to "label_code" in nominal_attributes object
	@XmlElement public float confidence;		

	public static final float DEFAULT_CONFIDENCE_VALUE = (float) 0.7;

	public QueryJsonObject() {
		confidence = DEFAULT_CONFIDENCE_VALUE;
	}


	abstract public QueryType getQueryType();
	abstract public void setQueryType(QueryType queryType);

	abstract public String getClassifierCode();
	abstract public void setClassifierCode(String classifier_code);
	abstract public String getLabelCode();
	abstract public void setLabelCode(String label_code);
	abstract public float getConfidence();
	abstract public void setConfidence( Float confidence);

	abstract public ComparatorType getComparator();

	abstract public void setComparator(ComparatorType comparator);


	abstract public String getTime();
	abstract public void setTime(String time);
	
	abstract public Date getDate();

	@Override
	public String toString() {
		StringBuilder object = new StringBuilder();
		
		object.append("{query_type: ").append(queryType).append(", ");
		object.append("classifier_code: ").append(classifier_code).append(", ");
		object.append("time: ").append(time).append(", ");
		object.append("label_code: ").append(label_code).append(", ");
		object.append("comparator: ").append(comparator).append(", ");
		object.append("confidence: ").append(confidence).append("}");
		
		return object.toString();
	}
}
