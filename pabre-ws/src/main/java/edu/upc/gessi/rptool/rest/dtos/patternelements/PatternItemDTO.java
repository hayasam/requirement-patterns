package edu.upc.gessi.rptool.rest.dtos.patternelements;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import edu.upc.gessi.rptool.domain.patternelements.Parameter;
import edu.upc.gessi.rptool.domain.patternelements.PatternItem;

@JsonInclude(Include.NON_NULL)
public class PatternItemDTO extends ReducedPatternObjectDTO {

    @InjectLink(value = "patterns/${instance.requirementPatternId}/versions/${instance.versionId}/forms/${instance.formId}/parts/${instance.id}", style = Style.ABSOLUTE)
    private URI uri;
    private String formText;
    private String questionText;
    private Integer numInstances;
    private Boolean available;
    private Integer statsNumInstances;
    private String artifactsRelation;
    private Set<ParameterDTO> parameters;
    @JsonIgnore
    private long requirementPatternId;
    @JsonIgnore
    private long versionId;
    @JsonIgnore
    private long formId;

    public PatternItemDTO(PatternItem pi, Long requirementPatternId, Long versionId, Long formId,
	    String artifactsRelation) {

	super(pi.getId());
	this.formText = pi.getPatternText();
	this.questionText = pi.getQuestionText();
	this.numInstances = pi.getNumInstances();
	this.available = pi.getAvailable();
	this.statsNumInstances = pi.getStatsNumInstances();
	this.artifactsRelation = artifactsRelation;
	this.parameters = new HashSet<>();
	for (Parameter p : pi.getParameters()) {
	    this.parameters.add(new ParameterDTO(p));
	}
	this.requirementPatternId = requirementPatternId;
	this.versionId = versionId;
	this.formId = formId;
    }

    public String getArtifactsRelation() {
	return artifactsRelation;
    }

    public URI getUri() {
	return uri;
    }

    @Override
    public long getId() {
	return id;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

    public long getRequirementPatternId() {
	return requirementPatternId;
    }

    public long getVersionId() {
	return versionId;
    }

    public long getFormId() {
	return formId;
    }

    public String getFormText() {
	return formText;
    }

    public String getQuestionText() {
	return questionText;
    }

    public Integer getNumInstances() {
	return numInstances;
    }

    public Boolean getAvailable() {
	return available;
    }

    public Integer getStatsNumInstances() {
	return statsNumInstances;
    }

    public Set<ParameterDTO> getParameters() {
	return parameters;
    }

}
