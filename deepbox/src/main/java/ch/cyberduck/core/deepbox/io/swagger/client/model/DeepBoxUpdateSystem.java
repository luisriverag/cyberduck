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
 * DeepBoxUpdateSystem
 */



public class DeepBoxUpdateSystem {
  @JsonProperty("boxType")
  private String boxType = null;

  public DeepBoxUpdateSystem boxType(String boxType) {
    this.boxType = boxType;
    return this;
  }

   /**
   * Get boxType
   * @return boxType
  **/
  @Schema(description = "")
  public String getBoxType() {
    return boxType;
  }

  public void setBoxType(String boxType) {
    this.boxType = boxType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeepBoxUpdateSystem deepBoxUpdateSystem = (DeepBoxUpdateSystem) o;
    return Objects.equals(this.boxType, deepBoxUpdateSystem.boxType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(boxType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeepBoxUpdateSystem {\n");
    
    sb.append("    boxType: ").append(toIndentedString(boxType)).append("\n");
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
