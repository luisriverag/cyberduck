/*
 * DeepBox
 * DeepBox API Documentation
 *
 * OpenAPI spec version: 1.0
 * Contact: info@deepcloud.swiss
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.deepbox.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * OutShareInfo
 */



public class OutShareInfo {
  @JsonProperty("withEmail")
  private String withEmail = null;

  @JsonProperty("pending")
  private Boolean pending = null;

  public OutShareInfo withEmail(String withEmail) {
    this.withEmail = withEmail;
    return this;
  }

   /**
   * Get withEmail
   * @return withEmail
  **/
  @Schema(description = "")
  public String getWithEmail() {
    return withEmail;
  }

  public void setWithEmail(String withEmail) {
    this.withEmail = withEmail;
  }

  public OutShareInfo pending(Boolean pending) {
    this.pending = pending;
    return this;
  }

   /**
   * Get pending
   * @return pending
  **/
  @Schema(description = "")
  public Boolean isPending() {
    return pending;
  }

  public void setPending(Boolean pending) {
    this.pending = pending;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OutShareInfo outShareInfo = (OutShareInfo) o;
    return Objects.equals(this.withEmail, outShareInfo.withEmail) &&
        Objects.equals(this.pending, outShareInfo.pending);
  }

  @Override
  public int hashCode() {
    return Objects.hash(withEmail, pending);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OutShareInfo {\n");
    
    sb.append("    withEmail: ").append(toIndentedString(withEmail)).append("\n");
    sb.append("    pending: ").append(toIndentedString(pending)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
