package com.uca.cinema.service;

import com.uca.cinema.domain.CUser;

public interface UserInterface {
	public void create(CUser user, String countryId, String municipalityId);
	public void update(CUser user, String countryId, String municipalityId);
}
