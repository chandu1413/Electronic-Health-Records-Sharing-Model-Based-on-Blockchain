package com.interfaces;

import java.io.InputStream;

import com.model.KycModel;

@FunctionalInterface
public interface UploadKycInterface {

	public String uploadKycToDB(KycModel kymodel);
}
