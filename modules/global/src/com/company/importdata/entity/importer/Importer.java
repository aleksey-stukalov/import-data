package com.company.importdata.entity.importer;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|beanName,description")
@MetaClass(name = "importdata$Importer")
public class Importer extends AbstractNotPersistentEntity {
    private static final long serialVersionUID = -5094342418060950482L;

    @MetaProperty(mandatory = true)
    protected String beanName;

    @MetaProperty
    protected String description;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}