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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * AdminTagAdd
 */



public class AdminTagAdd {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("i18n")
  private Map<String, String> i18n = null;

  /**
   * Gets or Sets spec
   */
  public enum SpecEnum {
    BARE("bare"),
    TEXT("text"),
    INTEGER("integer"),
    REAL("real"),
    DATE("date"),
    DATETIME("datetime");

    private String value;

    SpecEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static SpecEnum fromValue(String input) {
      for (SpecEnum b : SpecEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("spec")
  private SpecEnum spec = null;

  @JsonProperty("external")
  private Boolean external = null;

  @JsonProperty("colorId")
  private Integer colorId = null;

  public AdminTagAdd key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @Schema(description = "")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public AdminTagAdd name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(required = true, description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AdminTagAdd i18n(Map<String, String> i18n) {
    this.i18n = i18n;
    return this;
  }

  public AdminTagAdd putI18nItem(String key, String i18nItem) {
    if (this.i18n == null) {
      this.i18n = new HashMap<>();
    }
    this.i18n.put(key, i18nItem);
    return this;
  }

   /**
   * Get i18n
   * @return i18n
  **/
  @Schema(description = "")
  public Map<String, String> getI18n() {
    return i18n;
  }

  public void setI18n(Map<String, String> i18n) {
    this.i18n = i18n;
  }

  public AdminTagAdd spec(SpecEnum spec) {
    this.spec = spec;
    return this;
  }

   /**
   * Get spec
   * @return spec
  **/
  @Schema(description = "")
  public SpecEnum getSpec() {
    return spec;
  }

  public void setSpec(SpecEnum spec) {
    this.spec = spec;
  }

  public AdminTagAdd external(Boolean external) {
    this.external = external;
    return this;
  }

   /**
   * Get external
   * @return external
  **/
  @Schema(description = "")
  public Boolean isExternal() {
    return external;
  }

  public void setExternal(Boolean external) {
    this.external = external;
  }

  public AdminTagAdd colorId(Integer colorId) {
    this.colorId = colorId;
    return this;
  }

   /**
   * Get colorId
   * @return colorId
  **/
  @Schema(description = "")
  public Integer getColorId() {
    return colorId;
  }

  public void setColorId(Integer colorId) {
    this.colorId = colorId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminTagAdd adminTagAdd = (AdminTagAdd) o;
    return Objects.equals(this.key, adminTagAdd.key) &&
        Objects.equals(this.name, adminTagAdd.name) &&
        Objects.equals(this.i18n, adminTagAdd.i18n) &&
        Objects.equals(this.spec, adminTagAdd.spec) &&
        Objects.equals(this.external, adminTagAdd.external) &&
        Objects.equals(this.colorId, adminTagAdd.colorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, name, i18n, spec, external, colorId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminTagAdd {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    i18n: ").append(toIndentedString(i18n)).append("\n");
    sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
    sb.append("    external: ").append(toIndentedString(external)).append("\n");
    sb.append("    colorId: ").append(toIndentedString(colorId)).append("\n");
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
