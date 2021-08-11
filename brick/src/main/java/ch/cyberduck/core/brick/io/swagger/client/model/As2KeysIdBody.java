/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * As2KeysIdBody
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class As2KeysIdBody {
  @JsonProperty("as2_partnership_name")
  private String as2PartnershipName = null;

  public As2KeysIdBody as2PartnershipName(String as2PartnershipName) {
    this.as2PartnershipName = as2PartnershipName;
    return this;
  }

   /**
   * AS2 Partnership Name
   * @return as2PartnershipName
  **/
  @Schema(example = "Test", required = true, description = "AS2 Partnership Name")
  public String getAs2PartnershipName() {
    return as2PartnershipName;
  }

  public void setAs2PartnershipName(String as2PartnershipName) {
    this.as2PartnershipName = as2PartnershipName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    As2KeysIdBody as2KeysIdBody = (As2KeysIdBody) o;
    return Objects.equals(this.as2PartnershipName, as2KeysIdBody.as2PartnershipName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(as2PartnershipName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class As2KeysIdBody {\n");
    
    sb.append("    as2PartnershipName: ").append(toIndentedString(as2PartnershipName)).append("\n");
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