package com.bfws121a.webshop;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


@SelectPackages({"com.bfws121a.webshop.repositories",
                 "com.bfws121a.webshop.unitTest"})

@SuiteDisplayName("PipelineTests")

@Suite
public class MySuite {
}
