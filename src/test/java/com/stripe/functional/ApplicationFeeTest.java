package com.stripe.functional;

import static org.junit.Assert.assertNotNull;

import com.stripe.BaseStripeTest;
import com.stripe.exception.StripeException;
import com.stripe.model.ApplicationFee;
import com.stripe.model.ApplicationFeeCollection;
import com.stripe.net.APIResource;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ApplicationFeeTest extends BaseStripeTest {
  public static final String FEE_ID = "fee_123";

  private ApplicationFee getFeeFixture() throws StripeException {
    final ApplicationFee fee = ApplicationFee.retrieve(FEE_ID);
    resetNetworkSpy();
    return fee;
  }

  @Test
  public void testRetrieve() throws StripeException {
    final ApplicationFee fee = ApplicationFee.retrieve(FEE_ID);

    assertNotNull(fee);
    verifyRequest(
        APIResource.RequestMethod.GET,
        String.format("/v1/application_fees/%s", FEE_ID)
    );
  }

  @Test
  public void testList() throws StripeException {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("limit", 1);

    final ApplicationFeeCollection fees = ApplicationFee.list(params);

    assertNotNull(fees);
    verifyRequest(
        APIResource.RequestMethod.GET,
        String.format("/v1/application_fees"),
        params
    );
  }

  @Test
  public void testRefund() throws StripeException {
    final ApplicationFee fee = getFeeFixture();

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("amount", 100);

    final ApplicationFee refundedFee = fee.refund(params);

    assertNotNull(refundedFee);
    verifyRequest(
        APIResource.RequestMethod.POST,
        String.format("/v1/application_fees/%s/refund", fee.getId()),
        params
    );
  }
}
