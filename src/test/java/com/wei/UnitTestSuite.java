package com.wei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by weiwen on 9/22/16.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ItemTest.class,
        ItemTypeTest.class,
        ReadTextFileTest.class,
        ReceiptTest.class,
        SalesTaxesTest.class,
        WriteToTextFileTest.class
})

public class UnitTestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
