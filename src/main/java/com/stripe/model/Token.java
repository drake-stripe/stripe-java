package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Token extends APIResource implements HasId {
  @Getter(onMethod = @__({@Override})) String id;
  String object;
  Long amount;
  BankAccount bankAccount;
  Card card;
  String clientIp;
  Long created;
  String currency;
  String email;
  Boolean livemode;
  String type;
  Boolean used;

  public static Token create(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return create(params, (RequestOptions) null);
  }

  public static Token create(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.POST, classURL(Token.class), params, Token.class, options);
  }

  @Deprecated
  public static Token create(Map<String, Object> params, String apiKey)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return create(params, RequestOptions.builder().setApiKey(apiKey).build());
  }

  public static Token retrieve(String id) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return retrieve(id, (RequestOptions) null);
  }

  public static Token retrieve(String id, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.GET, instanceURL(Token.class, id), null, Token.class, options);
  }

  @Deprecated
  public static Token retrieve(String id, String apiKey)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return retrieve(id, RequestOptions.builder().setApiKey(apiKey).build());
  }
}
