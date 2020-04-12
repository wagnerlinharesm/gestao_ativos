package com.apirestful.gestaoativos.error;

// Classe com o builder utilizando ErrorDetails
public class ResourceNotFoundDetails extends ErrorDetails {


	public static final class Builder {
		private String tittle;
		private int status;
		private String detail;
		private long timestamp;
		private String developerMessage;

		private Builder() {
		}

		public static Builder newBuilder() {
			return new Builder();
		}

		public Builder tittle(String tittle) {
			this.tittle = tittle;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ResourceNotFoundDetails build() {
			ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
			resourceNotFoundDetails.developerMessage = this.developerMessage;
			resourceNotFoundDetails.status = this.status;
			resourceNotFoundDetails.tittle = this.tittle;
			resourceNotFoundDetails.detail = this.detail;
			resourceNotFoundDetails.timestamp = this.timestamp;
			return resourceNotFoundDetails;
		}
	}
}
