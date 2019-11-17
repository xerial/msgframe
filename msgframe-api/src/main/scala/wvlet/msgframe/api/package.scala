/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package wvlet.msgframe

/**
  *
  */
package object api {

  // Primitive types other than Int, Long, Float, Double, String, etc.
  type Numeric
  type Binary = Array[Byte]
  type Timestamp
  type MsgPack
  type AnyValue = MsgPack

  type Enum

  // Auxiliary types
  type Labels   = Map[String, AnyValue]
  type Duration = String
  case class LatLong(latitude: Double, longtitude: Double)
  case class Money(currencyCode: String, units: Int, nanos: Int)

  case class PostalAddress(regionCode: String,
                           languageCode: String,
                           postalCode: String,
                           addressLines: Seq[String],
                           recipients: Seq[String],
                           organization: Option[String])
}
