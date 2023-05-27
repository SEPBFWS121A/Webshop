package com.bfws121a.webshop;

import com.bfws121a.webshop.repositories.*;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;


@Suite
@SelectPackages("com/bfws121a/webshop/repositories")
/*@RunWith(Suite.class)

@Suite.SuiteClasses({
        H2ProdDeleteByNameTest.class,
        H2ProdRepoFindAllTest.class,
        H2ProdRepoFindAllTestProductive.class,
        H2ProdRepoSearchByNameTest.class,
        H2ProdRepoSearchByNameTest.class,
        H2ReviewRepoAddReviewTest.class,
        H2ReviewRepoFindByProdIDTest.class
})*/

public class JUnitTestSuite {
}
