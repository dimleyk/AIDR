package qa.qcri.aidr.output.entity;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import qa.qcri.aidr.output.utils.CollectionStatus;
import qa.qcri.aidr.output.utils.JsonDateDeSerializer;
import qa.qcri.aidr.output.utils.JsonDateSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(catalog = "aidr_fetch_manager", name = "AIDR_COLLECTION")
@XmlRootElement
public class AidrCollection implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4720813686204397970L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, name = "code", unique = true)
    private String code;

    @Column(length = 255, name = "name", unique = true)
    private String name;

    private String target;

    //@OneToOne(targetEntity = UserEntity.class, cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id", referencedColumnName = "id")
    //private UserEntity user;
    
    @Column(name = "user_id")
    private Integer userId;
    
    private Integer count;

    private CollectionStatus status;

    @Column(length = 1000, name = "track")
    private String track;

    private String follow;

    private String geo;

    private String langFilters;

    private Date startDate;

    private Date endDate;

    private Date createdDate;
    
    private Boolean publiclyListed;
    
    
    @Column(length = 1000, name = "last_document")
    private String lastDocument;

    private Integer durationHours;

    private Integer crisisType;

    /*
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "AIDR_COLLECTION_TO_MANAGER",
            joinColumns = {@JoinColumn(name = "id_collection")},
            inverseJoinColumns = {@JoinColumn(name = "id_manager")}
    )
    private List<UserEntity> managers;
	*/
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CollectionStatus getStatus() {
        return status;
    }

    public synchronized void setStatus(CollectionStatus status) {
        this.status = status;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using = JsonDateDeSerializer.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getEndDate() {
        return endDate;
    }

    @JsonDeserialize(using = JsonDateDeSerializer.class)
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getCreatedDate() {
        return createdDate;
    }

    @JsonDeserialize(using = JsonDateDeSerializer.class)
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastDocument() {
        return lastDocument;
    }

    public void setLastDocument(String lastDocument) {
        this.lastDocument = lastDocument;
    }

    /**
     * @return the langFilter
     */
    public String getLangFilters() {
        return langFilters;
    }

    /**
     * @param langFilter the langFilter to set
     */
    public void setLangFilters(String langFilter) {
        this.langFilters = langFilter;
    }

    /*
    public List<UserEntity> getManagers() {
        return managers;
    }

    public void setManagers(List<UserEntity> managers) {
        this.managers = managers;
    }
	*/
    
    public Integer getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(Integer durationHours) {
        this.durationHours = durationHours;
    }

    public Integer getCrisisType() {
        return crisisType;
    }

    public void setCrisisType(Integer crisisType) {
        this.crisisType = crisisType;
    }

    public Boolean getPubliclyListed() {
    	return publiclyListed;
    }
    
    public void setPubliclyListed(Boolean publiclyListed) {
    	this.publiclyListed = publiclyListed;
    }
}
