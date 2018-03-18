package rest.with.spring.handler;

public class VadidationErrorDetails extends ErrorDetail {

	private String field;
	private String fieldMessage;

	public static final class Builder {

		private String title;

		private int status;

		private String detail;

		private long timestamp;

		private String developerMessage;
		
		private String field;
		
		private String fieldMessage;
		
		private Builder() {

		}

		public static Builder newBuilder() {

			return new Builder();
		}

		public Builder title(String title) {
			this.title = title;
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
		
		public Builder field(String field) {
			this.field = field;
			return this;
		}
		
		public Builder fieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
			return this;
		}
		
		public VadidationErrorDetails build() {

			VadidationErrorDetails vadidationErrorDetails = new VadidationErrorDetails();

			vadidationErrorDetails.setTitle(title);
			vadidationErrorDetails.setStatus(status);
			vadidationErrorDetails.setDetail(detail);
			vadidationErrorDetails.setTimestamp(timestamp);
			vadidationErrorDetails.setDeveloperMessage(developerMessage);
			vadidationErrorDetails.setField(field);
			vadidationErrorDetails.setFieldMessage(fieldMessage);
			
			return vadidationErrorDetails;
		}
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}

	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}
}
