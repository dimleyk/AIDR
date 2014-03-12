package qa.qcri.aidr.output.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import qa.qcri.aidr.output.filter.ComparatorType;

@SuppressWarnings("serial")
@XmlRootElement(name="DateQueryJsonObject")
public class DateQueryJsonObject extends QueryJsonObject {
	
	public DateQueryJsonObject() {
		super();
	}
	
	
	@Override
	public QueryType getQueryType() {
		return queryType;
	}
	
	@Override
	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}
	
	@JsonProperty("comparator")
	public ComparatorType getComparator() {
		return comparator;
	}
	
	public void setComparator(ComparatorType comparator) {
		this.comparator = comparator;
	}
	
	@JsonProperty("time")
	public String getTime() {
		return time;
	}
	
	@Override
	public void setTime(String time) {
		this.time = time;
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

	@Override
	public String getClassifierCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClassifierCode(String classifier_code) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getLabelCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLabelCode(String label_code) {
		// TODO Auto-generated method stub
	}

	@Override
	public float getConfidence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setConfidence(Float confidence) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public String toString() {
		StringBuilder object = new StringBuilder();
		object.append("{query_type: ").append(queryType).append(", ");
		object.append("comparator: ").append(comparator).append(", ");
		object.append("time: ").append(time.toString()).append("}");
		return object.toString();
	}

}	


