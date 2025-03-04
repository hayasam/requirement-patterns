package edu.upc.gessi.rptool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.upc.gessi.rptool.domain.patternelements.RequirementPatternVersion;

import java.io.Serializable;

@Entity
@Table(name = "EXTERNAL_OBJECT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ExternalObject implements Identificable, Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "customGenerator")
    protected long id;

    @ManyToOne
    @JoinColumn(name = "PATTERN_VERSION_ID")
    protected RequirementPatternVersion patternVersion;

    public ExternalObject() {
	super();
    }

    public ExternalObject(RequirementPatternVersion patternVersion) {
	super();
	this.patternVersion = patternVersion;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public RequirementPatternVersion getPatternVersion() {
	return patternVersion;
    }

    public void setPatternVersion(RequirementPatternVersion patternVersion) {
	this.patternVersion = patternVersion;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.valueOf(id).hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null || (getClass() != obj.getClass())) return false;
	ExternalObject other = (ExternalObject) obj;
	return id == other.id;
    }

    @Override
    public String toString() {
	return "ExternalObject [id=" + id + ", patternVersion=" + patternVersion.getReason() + "]";
    }

}