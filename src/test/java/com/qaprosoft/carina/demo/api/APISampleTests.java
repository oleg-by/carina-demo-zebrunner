package com.qaprosoft.carina.demo.api;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APISampleTests implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testCreateProduct() {
        PostProductMethod postProductMethod = new PostProductMethod();
        postProductMethod.setProperties("api/products/product.properties");
        postProductMethod.callAPIExpectSuccess();
        postProductMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testGetProducts() {
        GetProductMethod getProductMethod = new GetProductMethod();
        getProductMethod.callAPIExpectSuccess();
        getProductMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getProductMethod.validateResponseAgainstSchema("api/products/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testDeleteProducts() {
        DeleteProductMethod deleteProductMethod = new DeleteProductMethod();
        deleteProductMethod.setProperties("api/products/product.properties");
        deleteProductMethod.callAPIExpectSuccess();
        deleteProductMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testPutProducts() {
        PutProductMethod putProductMethod = new PutProductMethod();
        putProductMethod.setProperties("api/products/product.properties");
        putProductMethod.callAPIExpectSuccess();
        putProductMethod.validateResponse();
    }

}
