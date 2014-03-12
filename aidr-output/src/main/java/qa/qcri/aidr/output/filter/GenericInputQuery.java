package qa.qcri.aidr.output.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name="GenericInputQuery")
public class GenericInputQuery extends QueryJsonObject {
	
	public GenericInputQuery() {
		confidence = DEFAULT_CONFIDENCE_VALUE;
	}
	
	@Override
	public String getClassifierCode() {
		return classifier_code;
	}

	@Override
	public void setClassifierCode(String classifier_code) {
		this.classifier_code = classifier_code;
		
	}

	@Override
	public String getLabelCode() {
		return label_code;
	}

	@Override
	public void setLabelCode(String label_code) {
		this.label_code = label_code;
		
	}

	@Override
	public float getConfidence() {
		return confidence;
	}

	@Override
	public void setConfidence(Float confidence) {
		this.confidence = confidence;
		
	}

	@Override
	public ComparatorType getComparator() {
		return comparator;
	}

	@Override
	public void setComparator(ComparatorType comparator) {
		this.comparator = comparator;
		
	}

	@Override
	public String getTime() {
		return time;
	}

	@Override
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public QueryType getQueryType() {
		return queryType;
	}

	@Override
	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public Date getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateFormat.parse(this.time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
