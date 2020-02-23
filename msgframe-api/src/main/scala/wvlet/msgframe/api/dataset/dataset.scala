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

package wvlet.msgframe.api.dataset

import wvlet.msgframe.api._
import wvlet.msgframe.api.iam.RoleType

/**
  *
  */
case class Dataset(
    id: String,
    description: Option[String],
    expirationWindow: Option[Duration],
    labels: Labels,
    createdAt: Timestamp,
    updatedAt: Timestamp
)

case class Table(
    id: String,
    dataset_id: String,
    kind: String,
    schema: TableSchema,
    description: Option[String],
    labels: Labels,
    expirationWindow: Option[Duration],
    timePartitioning: Option[TimePartitioning],
    createdAt: Timestamp,
    updatedAt: Timestamp
)

case class TimePartitioning(
    window: Duration = "1d"
)

sealed trait TableType
object TableType {
  case object REGULAR  extends TableType
  case object VIEW     extends TableType
  case object EXTERNAL extends TableType
}

case class TableSchema(
    columns: Seq[TableColumn]
)

case class TableColumn(
    name: String,
    typeName: String,
    typeDistribution: Option[TypeDistribution],
    isNullable: Boolean = true,
    description: Option[String]
)

case class TypeDistribution(
    // typeName -> occurrence frequency
    typeOccurrence: Map[String, Long]
)

sealed trait DataAccessPolicy
object DataAccessPolicyTarget {

  case class TableTarget(tableId: String, roleType: RoleType)
  case class ColumnFamilyTarget(tableId: String, columnNames: Seq[String], roleType: RoleType)
}
