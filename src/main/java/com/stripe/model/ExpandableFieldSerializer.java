package com.stripe.model;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ExpandableFieldSerializer implements JsonSerializer<ExpandableField<HasId>> {
	public JsonElement serialize(ExpandableField<HasId> src, Type typeOfSrc, JsonSerializationContext context) {
		if (src.isExpanded()) {
			return context.serialize(src.getExpanded());
		} else if (src.getId() != null) {
			return new JsonPrimitive(src.getId());
		} else {
			return null;
		}
	}
}
