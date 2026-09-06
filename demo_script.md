# 🎬 Niagara MCP — Production Script
> **Format:** Two separate tracks — record screen first, add AI voiceover after.

---

## 🤖 Recommended AI Voiceover Workflow

1. **Record all scenes** (this guide) — no talking, just clean screen action
2. **Edit clips** into one continuous video (any editor — Capcut, DaVinci, etc.)
3. **Feed the voiceover script** (Section B below) to an AI voice tool:
   - **ElevenLabs** — best quality, very natural pacing, free tier available
   - **Adobe Podcast (Enhance Speech)** — if you record your own voice and want it cleaned up
   - **Play.ht / Murf.ai** — good alternatives with professional voices
4. **Sync audio to video** — line up each scene's narration to the corresponding clip
5. *(Optional)* Add subtle background music at ~10–15% volume under the voiceover

---
---

# SECTION A — 🎥 Screen Recording Guide
> What to do on screen for each scene. No talking needed.

---

### SCENE 1 — Opening Shot (~15 sec)
**What to show:**
- Open the Niagara Workbench / any complex BMS UI (or just the project folder structure)
- Slowly scroll through it to show complexity — nested trees, config panels
- Let it sit for ~10 seconds, then cut

> 💡 **Tip:** If you don't have live Niagara, even showing the `histories.csv` with 330 rows of raw data, or the README structure, conveys the same "complexity" feeling.

---

### SCENE 2 — Architecture Diagram (~15 sec)
**What to show:**
- Open `docs/architecture.jpg` full screen
- Let it sit still — no scrolling needed

---

### SCENE 3 — Morning Briefing (~25 sec)
**What to show:**
- Open **Claude Desktop** (MCP server running in terminal — keep it visible in a corner or split screen)
- Type slowly and deliberately:
  > `Give me a morning briefing — what is the overall health of the building right now?`
- Hit Enter — let Claude's full response stream in
- **Hold on the response for 5–8 seconds** after it finishes generating

---

### SCENE 4A — AHU-1 Line Chart (~30 sec)
**What to show:**
- Same Claude session (continue the conversation)
- Type:
  > `Show me how AHU-1 zone temperature has changed this morning. I want to see the curve.`
- Let Claude generate the chart
- **Hold on the chart for 8–10 seconds** — this is a key visual moment, give it space
- Optionally scroll slowly to show the full chart

---

### SCENE 5 — Multi-System Pattern Query (~40 sec)
**What to show:**
- Type (this is the most important scene — type it slowly so it reads clearly on screen):
  > `Is anything unusual happening across the building systems this morning? Look at temperatures, air quality, and equipment faults together.`
- Hit Enter — **let Claude's full response stream in completely**
- **Slowly scroll through the response** — don't rush this
- **Hold on the final diagnosis/conclusion section for 8–10 seconds**

---

### SCENE 6 — Three Personas, Fast Cut (~45 sec)
**What to show:**  
Three back-to-back queries, each in a new conversation:

**Query 1 (Technician):**
> `Which points are faulted or overridden right now? Give me the paths so I can investigate.`
- Let it respond → hold 4 sec → cut

**Query 2 (Energy Manager):**
> `Was total building power consumption higher than normal last night? Flag any inefficiencies.`
- Let it respond → hold 4 sec → cut

**Query 3 (Executive):**
> `In one paragraph — what happened in this building today and should I be concerned?`
- Let it respond → hold 5 sec → cut

---

### SCENE 7 — Config Closeup (~10 sec)
**What to show:**
- Open `claude_desktop_config.json` in VS Code or any editor
- Zoom into the 4-line snippet
- Hold still

---

### SCENE 8 — Closing Title Card (~15 sec)
**What to show:**
- Create a simple black screen with white text (in any editor or even a slide):
  > *"Your building has always known this.*  
  > *Now you can ask it."*
- Fade to black

---
---

# SECTION B — 🎙️ Voiceover Script
> Clean narration only. Paste this directly into ElevenLabs / your AI voice tool of choice.  
> Each [SCENE X] label marks where that audio block begins — match to your video timeline.

---

**[SCENE 1 — Opening]**

This is what a building management system looks like today. Thousands of data points. Dozens of screens. And to get a single useful answer — is my equipment healthy, why is this room overheating, how much energy did we waste last night — you need to know exactly where to look, what to filter, and how to stitch together data from three different views. That's knowledge that takes years to build. What if none of that was required?

---

**[SCENE 2 — Architecture]**

Niagara MCP is a Spring Boot server that connects any AI agent — Claude, in this demo — directly to a Tridium Niagara 4 building system through 21 structured tools covering alarms, sensor histories, and live points. The AI doesn't just retrieve data. It thinks about it. And it gives you back exactly the view you asked for — in whatever form makes sense.

---

**[SCENE 3 — Morning Briefing]**

Let's start with someone who has no BMS training at all. A facilities manager, first thing Monday morning, asks one question. Claude doesn't list raw data. It synthesises across alarms, faulted points, and recent histories — and writes a complete morning briefing in plain English. No filters to set. No screens to navigate. One question, one complete situational picture.

---

**[SCENE 4A — AHU-1 Chart]**

Now that same manager wants to see a temperature trend in a problem zone — but there is no dashboard pre-built for it. Claude fetches the history data and renders a line chart, right in the conversation. The view didn't exist before this question. It was created for this question. That is the shift — from a fixed dashboard that only shows what someone pre-decided to build, to a fluid conversation that shows exactly what you need, when you need it.

---

**[SCENE 5 — Pattern Recognition]**

Here is where it goes beyond any dashboard. A dashboard can only show patterns it was designed to show. Claude can find patterns no one thought to look for. Three signals are converging in the same time window. AHU-4 fan speed dropped to zero at ten twenty-five AM. Zone 3 CO2 levels have been rising steadily since nine AM, now well above safe thresholds. And zone temperatures across AHU-1 and AHU-3 are both climbing. These patterns point to a single cause — a loss of fresh air circulation from the AHU-4 failure. This is not just a mechanical fault. It is now an indoor air quality event. That connection exists in the data. But no traditional dashboard would surface it automatically. No one had to know to look for it. The AI found the pattern. The AI connected the dots. The AI named the risk.

---

**[SCENE 6 — Three Personas]**

Same system. Same data. Different questions. A technician gets precise fault paths for investigation. An energy manager gets a peak versus off-peak analysis with anomaly callouts. And an executive gets one plain-English paragraph. No one needed to understand how the system works. They just needed to ask.

---

**[SCENE 7 — Config]**

And this is the entire integration. Four lines of configuration. Every tool auto-discovered. Any MCP-compatible AI agent connects.

---

**[SCENE 8 — Closing]**

Niagara MCP doesn't give you a better dashboard. It makes the dashboard irrelevant. Custom views. Pattern recognition. Cross-system analytics. Recommendations. Briefings. Charts. All from a question. All without expertise. All without a developer. Your building has always had this data. Now you can finally have a real conversation with it.

---
---

## ⏱️ Approximate Timeline

| Scene | Screen Duration | Voiceover Duration |
|-------|-----------------|--------------------|  
| 1 — Opening shot | 15 sec (image) | 25 sec |
| 2 — Architecture | 15 sec (image) | 18 sec |
| 3 — Morning briefing | 25 sec | 22 sec |
| 4 — AHU-1 line chart | 30 sec | 22 sec |
| 5 — Pattern recognition | 40 sec | 45 sec |
| 6 — Three personas | 45 sec | 22 sec |
| 7 — Config | 10 sec | 10 sec |
| 8 — Closing | 15 sec | 22 sec |
| **Total** | **~3:15** | **~3:06** |

> 💡 **Sync tip:** Screen duration is longer than voiceover in most scenes — that's intentional.  
> Let the screen breathe after the voiceover ends. Don't rush to cut.  
> Scene 5 is the only one where voiceover is slightly longer — slow your scroll to fill it.
