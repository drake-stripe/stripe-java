package com.stripe.model;

import static org.junit.Assert.assertNotNull;

import com.stripe.BaseStripeTest;
import com.stripe.net.APIResource;

import org.junit.Test;

public class ChargeOutcomeTest extends BaseStripeTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getResourceAsString("/api_fixtures/charge_outcome.json");
    final ChargeOutcome object = APIResource.GSON.fromJson(data, ChargeOutcome.class);
    assertNotNull(object);
    assertNotNull(object.getNetworkStatus());
  }
}
