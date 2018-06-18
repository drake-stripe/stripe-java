package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.Map;

public class ExternalAccountCollection extends StripeCollection<ExternalAccount> {
  // <editor-fold desc="all">
  @Deprecated
  public ExternalAccountCollection all(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return list(params, null);
  }

  @Deprecated
  public ExternalAccountCollection all(Map<String, Object> params,
                     RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return list(params, options);
  }
  // </editor-fold>

  // <editor-fold desc="create">
  public ExternalAccount create(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return create(params, null);
  }

  public ExternalAccount create(Map<String, Object> params,
                  RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return APIResource.request(APIResource.RequestMethod.POST, String.format("%s%s",
        Stripe.getApiBase(), this.getURL()), params, ExternalAccount.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="list">
  public ExternalAccountCollection list(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return list(params, null);
  }

  public ExternalAccountCollection list(Map<String, Object> params,
                      RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    String url = String.format("%s%s", Stripe.getApiBase(), this.getURL());
    return APIResource.requestCollection(url, params, ExternalAccountCollection.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="retrieve">
  public ExternalAccount retrieve(String id) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return retrieve(id, null);
  }

  public ExternalAccount retrieve(String id, RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return APIResource.request(APIResource.RequestMethod.GET, String.format("%s%s/%s",
        Stripe.getApiBase(), this.getURL(), id), null, ExternalAccount.class, options);
  }
  // </editor-fold>
}
