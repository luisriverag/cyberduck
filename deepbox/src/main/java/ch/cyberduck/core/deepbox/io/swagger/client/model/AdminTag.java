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
 * AdminTag
 */



public class AdminTag {
  @JsonProperty("tagId")
  private String tagId = null;

  @JsonProperty("tagKey")
  private String tagKey = null;

  @JsonProperty("tagName")
  private String tagName = null;

  @JsonProperty("i18n")
  private Map<String, String> i18n = null;

  /**
   * Gets or Sets tagSpec
   */
  public enum TagSpecEnum {
    BARE("bare"),
    TEXT("text"),
    INTEGER("integer"),
    REAL("real"),
    DATE("date"),
    DATETIME("datetime");

    private String value;

    TagSpecEnum(String value) {
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
    public static TagSpecEnum fromValue(String input) {
      for (TagSpecEnum b : TagSpecEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("tagSpec")
  private TagSpecEnum tagSpec = null;

  @JsonProperty("external")
  private Boolean external = null;

  @JsonProperty("colorId")
  private Integer colorId = null;

  @JsonProperty("displayName")
  private String displayName = null;

  @JsonProperty("colorBg")
  private String colorBg = null;

  @JsonProperty("colorFg")
  private String colorFg = null;

  public AdminTag tagId(String tagId) {
    this.tagId = tagId;
    return this;
  }

   /**
   * Get tagId
   * @return tagId
  **/
  @Schema(description = "")
  public String getTagId() {
    return tagId;
  }

  public void setTagId(String tagId) {
    this.tagId = tagId;
  }

  public AdminTag tagKey(String tagKey) {
    this.tagKey = tagKey;
    return this;
  }

   /**
   * Get tagKey
   * @return tagKey
  **/
  @Schema(description = "")
  public String getTagKey() {
    return tagKey;
  }

  public void setTagKey(String tagKey) {
    this.tagKey = tagKey;
  }

  public AdminTag tagName(String tagName) {
    this.tagName = tagName;
    return this;
  }

   /**
   * Get tagName
   * @return tagName
  **/
  @Schema(description = "")
  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  public AdminTag i18n(Map<String, String> i18n) {
    this.i18n = i18n;
    return this;
  }

  public AdminTag putI18nItem(String key, String i18nItem) {
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

  public AdminTag tagSpec(TagSpecEnum tagSpec) {
    this.tagSpec = tagSpec;
    return this;
  }

   /**
   * Get tagSpec
   * @return tagSpec
  **/
  @Schema(description = "")
  public TagSpecEnum getTagSpec() {
    return tagSpec;
  }

  public void setTagSpec(TagSpecEnum tagSpec) {
    this.tagSpec = tagSpec;
  }

  public AdminTag external(Boolean external) {
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

  public AdminTag colorId(Integer colorId) {
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

  public AdminTag displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @Schema(description = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public AdminTag colorBg(String colorBg) {
    this.colorBg = colorBg;
    return this;
  }

   /**
   * Get colorBg
   * @return colorBg
  **/
  @Schema(description = "")
  public String getColorBg() {
    return colorBg;
  }

  public void setColorBg(String colorBg) {
    this.colorBg = colorBg;
  }

  public AdminTag colorFg(String colorFg) {
    this.colorFg = colorFg;
    return this;
  }

   /**
   * Get colorFg
   * @return colorFg
  **/
  @Schema(description = "")
  public String getColorFg() {
    return colorFg;
  }

  public void setColorFg(String colorFg) {
    this.colorFg = colorFg;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminTag adminTag = (AdminTag) o;
    return Objects.equals(this.tagId, adminTag.tagId) &&
        Objects.equals(this.tagKey, adminTag.tagKey) &&
        Objects.equals(this.tagName, adminTag.tagName) &&
        Objects.equals(this.i18n, adminTag.i18n) &&
        Objects.equals(this.tagSpec, adminTag.tagSpec) &&
        Objects.equals(this.external, adminTag.external) &&
        Objects.equals(this.colorId, adminTag.colorId) &&
        Objects.equals(this.displayName, adminTag.displayName) &&
        Objects.equals(this.colorBg, adminTag.colorBg) &&
        Objects.equals(this.colorFg, adminTag.colorFg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagId, tagKey, tagName, i18n, tagSpec, external, colorId, displayName, colorBg, colorFg);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminTag {\n");
    
    sb.append("    tagId: ").append(toIndentedString(tagId)).append("\n");
    sb.append("    tagKey: ").append(toIndentedString(tagKey)).append("\n");
    sb.append("    tagName: ").append(toIndentedString(tagName)).append("\n");
    sb.append("    i18n: ").append(toIndentedString(i18n)).append("\n");
    sb.append("    tagSpec: ").append(toIndentedString(tagSpec)).append("\n");
    sb.append("    external: ").append(toIndentedString(external)).append("\n");
    sb.append("    colorId: ").append(toIndentedString(colorId)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    colorBg: ").append(toIndentedString(colorBg)).append("\n");
    sb.append("    colorFg: ").append(toIndentedString(colorFg)).append("\n");
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