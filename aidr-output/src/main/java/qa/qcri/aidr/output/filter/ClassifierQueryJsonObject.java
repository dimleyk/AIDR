package qa.qcri.aidr.output.filter;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import qa.qcri.aidr.output.filter.ComparatorType;

@SuppressWarnings("serial")
@XmlRootElement(name="ClassifierQueryJsonObject")
public class ClassifierQueryJsonObject extends QueryJsonObject {
	
	public ClassifierQueryJsonObject() {
		super();
		confidence = DEFAULT_CONFIDENCE_VALUE;					// default setting
		comparator = ComparatorType.has_confidence;	// default setting
	}
	
	
	@Override
	public QueryType getQueryType() {
		return queryType;
	}
	
	@Override
	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}
	
	
	@JsonProperty("classifier_code")
	public String getClassifierCode() {
		return classifier_code;
	}
	
	
	public void setClassifierCode(String classifier_code) {
		this.classifier_code = classifier_code;
	}
	
	@JsonProperty("label_code")
	public String getLabelCode() {
		return label_code;
	}
	
	public void setLabelCode(String label_code) {
		this.label_code = label_code;
	}
	
	@JsonProperty("confidence")
	public float getConfidence() {
		return confidence;
	}
	
	public void setConfidence(Float confidence) {
		this.confidence = confidence;
	}
	
	@JsonProperty("comparator")
	public ComparatorType getComparator() {
		return comparator;
	}
	
	public void setComparator(ComparatorType comparator) {
		this.comparator = comparator;
	}


	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTime(String time) {
		time = null;
	}
	
	@Override
	public String toString() {
		StringBuilder object = new StringBuilder();
		object.append("{query_type: ").append(queryType).append(", ");
		object.append("classifier_code: ").append(classifier_code).append(", ");
		object.append("label_code: ").append(label_code).append(", ");
		object.append("comparator: ").append(comparator).append(", ");
		object.append("confidence: ").append(confidence).append("}");
		return object.toString();
	}


	@Override
	public Date getDate() {
		return null;
	}

}
