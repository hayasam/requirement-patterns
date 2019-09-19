package edu.upc.gessi.rptool.rest.dtos.patternelements;

import java.net.URI;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import edu.upc.gessi.rptool.domain.patternelements.ExtendedPart;
import edu.upc.gessi.rptool.domain.patternelements.RequirementForm;

@JsonInclude(Include.NON_NULL)
public class RequirementFormDTO extends PatternElementDTO implements Comparable<RequirementFormDTO> {
    @InjectLink(value = "patterns/${instance.requirementPatternId}/versions/${instance.versionId}/forms/${instance.id}", style = Style.ABSOLUTE)
    private URI uri;
    private String name;
    private String author;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    private Date modificationDate;
    private Integer numInstances;
    private Boolean available;
    private Integer statsNumInstances;
    private Integer statsNumAssociates;
    private FixedPartDTO fixedPart;
    private Set<ExtendedPartDTO> extendedParts;
    private Short pos;
    @JsonIgnore
    private long requirementPatternId;
    @JsonIgnore
    private long versionId;

    public RequirementFormDTO(RequirementForm rf, Long requirementPatternId, Long versionId) {
	super(rf);
	this.name = rf.getName();
	this.author = rf.getAuthor();
	this.modificationDate = rf.getVersion();
	this.numInstances = rf.getNumInstances();
	this.available = rf.getAvailable();
	this.statsNumInstances = rf.getStatsNumInstances();
	this.statsNumAssociates = rf.getStatsNumAssociates();
	this.fixedPart = new FixedPartDTO(rf.getFixedPart(), requirementPatternId, versionId, this.getId(),
		rf.getFixedPart().getArtifactRelation());
	this.extendedParts = new TreeSet<>();
	for (ExtendedPart ep : rf.getExtendedParts()) {
	    this.extendedParts.add(
		    new ExtendedPartDTO(ep, requirementPatternId, versionId, this.getId(), ep.getArtifactRelation()));
	}
	this.requirementPatternId = requirementPatternId;
	this.versionId = versionId;
	this.pos = rf.getPos();
    }

    public Short getPos() {
	return pos;
    }

    public String getName() {
        return name;
    }

    public long getRequirementPatternId() {
	return requirementPatternId;
    }

    public URI getUri() {
        return uri;
    }

    public void setRequirementPatternId(long requirementPatternId) {
	this.requirementPatternId = requirementPatternId;
    }

    public String getAuthor() {
        return author;
    }

    public long getVersionId() {
	return versionId;
    }

    public Integer getNumInstances() {
        return numInstances;
    }

    public Date getModificationDate() {
	return modificationDate;
    }

    public Boolean getAvailable() {
	return available;
    }

    public Integer getStatsNumInstances() {
	return statsNumInstances;
    }

    public FixedPartDTO getFixedPart() {
	return fixedPart;
    }

    public Integer getStatsNumAssociates() {
        return statsNumAssociates;
    }

    public Set<ExtendedPartDTO> getExtendedParts() {
	return extendedParts;
    }

    @Override
    public int compareTo(RequirementFormDTO o) {
	if (o == null)
	    throw new NullPointerException("Comparison between null objects is not allowed");
	try {
	    return this.pos - o.getPos();
	} catch (NullPointerException e) {
	    return 0;
	}
    }
}
