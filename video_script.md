# 🎬 Niagara MCP — Demo Video Script
> **Duration:** ~4–5 min | **Core Message:**  
> *"Deep building intelligence, for anyone — no training, no dashboard, no engineering degree required."*

---

## 🎙️ INTRO — The Real Problem
**[Scene: Fade in — a Niagara workbench with complex navigation trees, dozens of menus]**

> **Voiceover:**
> "This is what a building management system looks like today.
>
> Thousands of data points. Dozens of screens.
> And to get a single useful answer — *Is my equipment healthy? Why is this room overheating?
> How much energy did we waste last night?* —
> you need to know exactly where to look, what to filter,
> and how to stitch together data from three different views.
>
> That's knowledge that takes years to build.
>
> **What if none of that was required?**
>
> What if you could ask — in plain English — and get a complete picture?
> A view tailored to your question. A pattern you didn't know to look for.
> An analysis that would take an engineer an hour, delivered in ten seconds.
>
> That's Niagara MCP."

---

## 🏗️ SCENE 1 — What It Is (15 sec)
**[Scene: Clean architecture diagram]**

> **Voiceover:**
> "Niagara MCP is a Spring Boot server that connects any AI agent —
> Claude, in this demo — directly to a Tridium Niagara 4 building system
> through 21 structured tools covering alarms, sensor histories, and live points.
>
> The AI doesn't just retrieve data. It thinks about it.
> And it gives you back exactly the view you asked for — in whatever form makes sense."

---

## 🧑‍💼 SCENE 2 — "I Just Want to Know What's Going On" (60 sec)
**[Scene: Claude Desktop — persona: a non-technical Facilities Manager]**

> **Voiceover:**
> "Let's start with someone who has no BMS training at all.
> A facilities manager walks in on a Monday morning and asks one question:"

> **[Type in Claude:]**
> *"Give me a morning briefing — what's the overall health of the building right now?"*

> **Voiceover (while Claude responds):**
> "Claude doesn't just list data. It synthesises across alarms, faulted points, and recent histories —
> and writes a **morning briefing** in plain English.
>
> *(Claude responds with something like:)*
> *'Good morning. The building has 2 active critical alarms, 1 piece of equipment offline,
> and Zone-3 CO₂ levels are elevated above safe thresholds.
> AHU-4 has been non-operational since 10:25 AM yesterday. Recommend immediate inspection.'*
>
> No training required. No filters to set.
> One question → a complete situational picture."

---

## 📊 SCENE 3 — Custom View, On Demand (60 sec)
**[Scene: Claude Desktop — showing chart generation]**

> **Voiceover:**
> "Now let's say that same manager wants to *see* the temperature trend in a problem zone —
> but there's no dashboard pre-built for it."

> **[Type in Claude:]**
> *"Show me how AHU-1 zone temperature has changed this morning. I want to see the curve."*

> **Voiceover:**
> "Claude fetches the history data and renders a **line chart, right in the conversation** —
> timestamped, annotated, no BI tool, no Grafana, no developer needed.
>
> The view didn't exist before this question. It was created *for* this question.
>
> Now watch what happens when they push further:"

> **[Type in Claude:]**
> *"And what about Chiller-1 energy consumption — did it trend unusually overnight?"*

> **Voiceover:**
> "A completely different data stream. A completely different chart.
> Generated in the same conversation, in seconds.
>
> This is the shift: from a **fixed dashboard** that shows what someone pre-decided to build,
> to a **fluid conversation** that shows exactly what you need, when you need it."

---

## 🔍 SCENE 4 — Pattern Recognition No One Asked For (75 sec)
**[Scene: Claude Desktop — the most powerful scene]**

> **Voiceover:**
> "Here's where it goes beyond any dashboard.
> A dashboard can only show patterns it was designed to show.
> Claude can find patterns **no one thought to look for**."

> **[Type in Claude:]**
> *"Is anything unusual happening across the building systems this morning?
> Look at temperatures, air quality, and equipment faults together."*

> **Voiceover (while Claude processes — let it breathe):**
> "Claude is now doing something that would take an experienced engineer 30 minutes:
> pulling histories across HVAC, IAQ, and electrical systems simultaneously —
> and looking for connections between them.
>
> *(Claude responds with correlated analysis — e.g.:)*
> *'Three signals are converging in the same time window:*
> *AHU-4 fan speed dropped to zero at 10:25 AM.*
> *Zone-3 CO₂ levels have been rising steadily since 9 AM — now at 1,340 ppm, well above the 1,000 ppm threshold.*
> *AHU-1 and AHU-3 zone temperatures are both climbing, reaching 29°C and 31°C respectively.*
> *These patterns are consistent with a loss of fresh air circulation caused by the AHU-4 failure.
> This is not just an equipment fault — it is now an indoor air quality event.'*
>
> That connection — between a mechanical fault and a building-wide IAQ consequence —
> exists in the data. But no traditional dashboard would surface it automatically.
>
> No one had to know to look for it.
> **The AI found the pattern. The AI connected the dots. The AI named the risk.**"

---

## ⚡ SCENE 5 — Analytics for Every Audience (45 sec)
**[Scene: Quick back-to-back queries showing different personas]**

> **Voiceover:**
> "The same system, different questions, different audiences."

> **[Type in Claude — as a technician:]**
> *"Which points are faulted or overridden right now? Give me the paths so I can investigate."*
> *(Gets a precise technical list with Niagara station paths)*

> **[Type in Claude — as an energy manager:]**
> *"Was total building power consumption higher than normal last night? 
> Compare peak vs off-peak and flag inefficiencies."*
> *(Gets a trend analysis across the 15-minute interval power history with anomaly callouts)*

> **[Type in Claude — as a C-suite exec:]**
> *"In one paragraph — what happened in this building today and should I be concerned?"*
> *(Gets a plain English executive summary)*

> **Voiceover:**
> "Same data. Same connection. Completely different intelligence for each person —
> without any of them needing to understand how the system works."

---

## 🔌 SCENE 6 — Setup: Four Lines (10 sec)
**[Scene: `claude_desktop_config.json` — brief]**

```json
{
  "mcpServers": {
    "niagara-bms": {
      "url": "http://localhost:8080/mcp",
      "transport": "streamable-http"
    }
  }
}
```

> **Voiceover:**
> "This is the entire integration. Four lines.
> Every tool auto-discovered. Any MCP-compatible AI connects."

---

## 🚀 CLOSING (20 sec)
**[Scene: Title card — "Your building has always known this. Now you can ask it."]**

> **Voiceover:**
> "Niagara MCP doesn't give you a better dashboard.
> It makes the dashboard irrelevant.
>
> Custom views. Pattern recognition. Cross-system analytics.
> Recommendations. Briefings. Charts. All from a question.
> All without expertise. All without a developer.
>
> Your building has always had this data.
> Now you can finally have a real conversation with it."

---

## 📋 Demo Queries Cheat Sheet

| Scene | Who's Asking | Query | What the AI Produces |
|-------|-------------|-------|---------------------|
| **2** | FM Manager | *"Give me a morning building health briefing"* | Plain-English situational summary across all systems |
| **3A** | Manager | *"Show AHU-1 zone temp trend this morning — I want to see the curve"* | On-demand line chart, no dashboard needed |
| **3B** | Manager | *"Did Chiller-1 energy trend unusually overnight?"* | Second chart in same conversation, different data stream |
| **4** | Anyone | *"Anything unusual across temperatures, air quality, and faults together?"* | Multi-system pattern correlation → AHU-4 failure = IAQ event diagnosis |
| **5A** | Technician | *"Which points are faulted or overridden? Give me paths."* | Technical fault list with Niagara station paths |
| **5B** | Energy Mgr | *"Was power higher than normal last night? Flag inefficiencies."* | Peak vs off-peak trend analysis with anomaly callouts |
| **5C** | C-Suite | *"In one paragraph — what happened today, should I be concerned?"* | Executive-level plain English summary |

---

## 🎬 Recording Tips

- **Scene 4 is the centrepiece** — let Claude's response appear in full before you continue voiceover. The moment the cross-system correlation lands is the most powerful moment in the video. Pause on it.
- **Don't say "the AI called a tool"** — the audience doesn't need to know about tools. They should only see: question → intelligence.
- **Scene 5 three-query sequence** works best as a fast cut — type, get response, cut, type, get response — keeps energy high.
- **Opening contrast** matters: show the real Niagara workbench UI briefly (5 sec) before the voiceover. The complexity contrast sets up the "what if none of that was required" hook perfectly.
