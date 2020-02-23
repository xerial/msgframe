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

package wvlet.msgframe.api.iam

import wvlet.msgframe.api._

case class Organization(
    id: String,
    name: String,
    description: Option[String]
)

case class User(
    id: String,
    name: String,
    email: String,
    description: Option[String],
    labels: Labels
)

case class UserGroup(
    id: String,
    name: String,
    description: Option[String],
    // user ids
    users: Seq[String]
)

case class Policy(
    id: String,
    version: Int,
    bindings: Seq[RoleBinding]
)

case class RoleBinding(
    role_id: String,
    members: Seq[String]
)

case class Role(
    id: String,
    name: String,
    roleType: RoleType
)

sealed trait RoleType
object RoleType {
  case object Viewer extends RoleType
  case object Editor extends RoleType
  case object Owner  extends RoleType
  case object Admin  extends RoleType
}
