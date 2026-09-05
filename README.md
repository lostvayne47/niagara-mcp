# niagara-mcp

A Spring Boot MCP (Model Context Protocol) server that exposes BMS (Building Management System) data — **Alarms**, **Histories**, and **Points** — as tools consumable by AI assistants.

---

## Project Structure

```
src/main/
│
├── java/com/techDay/niagaraMcp/
│   │
│   ├── model/
│   │   ├── Alarm.java          # BMS Alarm record (id, displayName, sourcePath, priority, state, acknowledged, timestamp, acknowledgedBy, alarmClass)
│   │   ├── History.java        # BMS History/Trend record (id, displayName, sourcePath, value, unit, timestamp, interval, quality)
│   │   └── Point.java          # BMS Point record (id, displayName, path, value, unit, type, writable, status)
│   │
│   ├── repository/
│   │   ├── AlarmRepository.java    # Loads alarms from alarms.csv at startup
│   │   ├── HistoryRepository.java  # Loads history records from histories.csv at startup
│   │   └── PointRepository.java    # Loads points from points.csv at startup
│   │
│   ├── service/
│   │   ├── AlarmService.java       # Alarm business logic layer
│   │   ├── HistoryService.java     # History business logic layer
│   │   └── PointService.java       # Point business logic layer
│   │
│   ├── tool/
│   │   ├── AlarmTool.java          # MCP-exposed alarm tools
│   │   ├── HistoryTool.java        # MCP-exposed history tools
│   │   └── PointTool.java          # MCP-exposed point tools
│   │
│   └── NiagaraMcpApplication.java  # Spring Boot entry point
│
└── resources/
    └── mock-data/
        ├── alarms.csv              # Mock alarm data (add rows to scale up)
        ├── histories.csv           # Mock history/trend data (add rows to scale up)
        └── points.csv              # Mock point data (add rows to scale up)
```

---

## Mock Data (CSV)

Mock data lives in `src/main/resources/mock-data/`. Each repository reads its CSV at startup via `ClassPathResource` and **Apache Commons CSV**. No database or code changes needed — just add rows to scale up.

### alarms.csv
| Column | Type | Notes |
|--------|------|-------|
| `id` | String | e.g. `ALM-001` |
| `displayName` | String | Human-readable alarm name |
| `sourcePath` | String | Niagara station path |
| `priority` | Enum | `CRITICAL`, `HIGH`, `MEDIUM`, `LOW` |
| `state` | Enum | `ACTIVE`, `NORMAL`, `OFFNORMAL` |
| `acknowledged` | boolean | `true` / `false` |
| `timestamp` | ISO DateTime | e.g. `2026-09-05T08:15:00` |
| `acknowledgedBy` | String | Blank if unacknowledged |
| `alarmClass` | String | e.g. `LifeSafety`, `Mechanical`, `Electrical` |

### histories.csv
| Column | Type | Notes |
|--------|------|-------|
| `id` | String | e.g. `HST-001` |
| `displayName` | String | Human-readable history name |
| `sourcePath` | String | Niagara station path |
| `value` | Double | Blank if quality is `BAD` |
| `unit` | String | Engineering unit, e.g. `°C`, `kWh`, `V` |
| `timestamp` | ISO DateTime | Last recorded timestamp |
| `interval` | int | Logging interval in seconds |
| `quality` | Enum | `OK`, `BAD`, `UNCERTAIN` |

### points.csv
| Column | Type | Notes |
|--------|------|-------|
| `id` | String | e.g. `PNT-001` |
| `displayName` | String | Human-readable point name |
| `path` | String | Niagara station path |
| `value` | String | Current value (any type serialized as string) |
| `unit` | String | Engineering unit, blank for non-numeric |
| `type` | Enum | `NUMERIC`, `BOOLEAN`, `ENUM`, `STRING` |
| `writable` | boolean | `true` if operator-commandable |
| `status` | Enum | `OK`, `FAULT`, `DISABLED`, `OVERRIDDEN` |

---

## MCP Tools

### 🔔 Alarm Tools
| Tool | Description |
|------|-------------|
| `getAlarmById` | Get an alarm by its unique ID (e.g. `ALM-001`) |
| `getAlarmByName` | Get an alarm by its display name |
| `getAllAlarms` | Get all alarms regardless of state |
| `getAllActiveAlarms` | Get all alarms with state `ACTIVE` |
| `getAllAcknowledgedAlarms` | Get all operator-acknowledged alarms |
| `getAllUnacknowledgedAlarms` | Get all alarms pending acknowledgement |
| `getAlarmsByPriority` | Filter alarms by priority (`CRITICAL`, `HIGH`, `MEDIUM`, `LOW`) |
| `getAlarmsByClass` | Filter alarms by class (e.g. `LifeSafety`, `Mechanical`, `Electrical`) |

### 📈 History Tools
| Tool | Description |
|------|-------------|
| `getHistoryById` | Get a history record by its unique ID (e.g. `HST-001`) |
| `getHistoryByName` | Get a history record by its display name |
| `getAllHistories` | Get all history/trend records |
| `getHistoriesBySourcePath` | Get records for a specific Niagara station path |
| `getHistoriesByQuality` | Filter records by quality (`OK`, `BAD`, `UNCERTAIN`) |
| `getHistoriesByUnit` | Filter records by engineering unit (e.g. `°C`, `kWh`) |

### 📡 Point Tools
| Tool | Description |
|------|-------------|
| `getPointById` | Get a point by its unique ID (e.g. `PNT-001`) |
| `getPointByName` | Get a point by its display name |
| `getPointByPath` | Get a point by its full Niagara station path |
| `getAllPoints` | Get all points in the system |
| `getAllWritablePoints` | Get all operator-commandable points |
| `getPointsByStatus` | Filter points by status (`OK`, `FAULT`, `DISABLED`, `OVERRIDDEN`) |
| `getPointsByType` | Filter points by data type (`NUMERIC`, `BOOLEAN`, `ENUM`, `STRING`) |

---

## Domain Models

### Alarm
```java
record Alarm(String id, String displayName, String sourcePath,
             AlarmPriority priority, AlarmState state,
             boolean acknowledged, LocalDateTime timestamp,
             String acknowledgedBy, String alarmClass)

enum AlarmPriority { CRITICAL, HIGH, MEDIUM, LOW }
enum AlarmState    { ACTIVE, NORMAL, OFFNORMAL }
```

### History
```java
record History(String id, String displayName, String sourcePath,
               Double value, String unit, LocalDateTime timestamp,
               int interval, HistoryQuality quality)

enum HistoryQuality { OK, BAD, UNCERTAIN }
```

### Point
```java
record Point(String id, String displayName, String path,
             String value, String unit,
             PointType type, boolean writable, PointStatus status)

enum PointType   { NUMERIC, BOOLEAN, ENUM, STRING }
enum PointStatus { OK, FAULT, DISABLED, OVERRIDDEN }
```

---

## Tech Stack

- **Java 17**
- **Spring Boot 4**
- **Spring AI MCP Server**
- **Apache Commons CSV** — CSV parsing for mock data
- **Lombok**
- **Gradle**

---

## Running Locally

```bash
./gradlew bootRun
```

> CSV files are loaded from `src/main/resources/mock-data/` at startup via `@PostConstruct`.
> To add more mock data, simply append rows to the CSV files and restart.
