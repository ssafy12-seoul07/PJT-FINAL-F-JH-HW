import matplotlib.pyplot as plt
import matplotlib.dates as mdates
from datetime import datetime

# Sample data for issues
issues = [
    {"title": "Issue 1", "start_date": datetime(2024, 11, 1), "end_date": datetime(2024, 11, 10)},
    {"title": "Issue 2", "start_date": datetime(2024, 11, 5), "end_date": datetime(2024, 11, 15)},
    {"title": "Issue 3", "start_date": datetime(2024, 11, 10), "end_date": datetime(2024, 11, 20)},
    {"title": "Issue 4", "start_date": datetime(2024, 11, 15), "end_date": datetime(2024, 11, 25)},
]

# Generate Gantt Chart with a clean and simple design
fig, ax = plt.subplots(figsize=(12, 7))

# Define bar height and colors for a clean look
bar_height = 0.4
colors = ["#6baed6", "#3182bd", "#08519c", "#08306b"]
today = datetime.now()

# Plot each issue as a simple bar
for i, issue in enumerate(issues):
    title = issue["title"]
    start_date = mdates.date2num(issue["start_date"])  # Convert start date to numerical format
    end_date = mdates.date2num(issue["end_date"])      # Convert end date to numerical format
    duration = end_date - start_date
    color = colors[i % len(colors)]
    
    # Draw the bar with ax.barh
    ax.barh(title, duration, left=start_date, color=color, height=bar_height, alpha=0.8)
    # Add text label for the duration on each bar
    ax.text(end_date, i, f'{int(duration)} days', va='center', ha='left', fontsize=9, color='black', alpha=0.8)

# Add today’s date line for reference
ax.axvline(mdates.date2num(today), color="red", linestyle="--", linewidth=1.2, label="Today")

# Set x-axis formatting for dates and enhance layout
ax.xaxis.set_major_locator(mdates.DayLocator(interval=3))
ax.xaxis.set_major_formatter(mdates.DateFormatter("%Y-%m-%d"))
plt.xticks(rotation=45, fontsize=9, color='gray')
plt.yticks(fontsize=10, color='gray')

# Title and labels with enhanced style
plt.title("Team Progress and Schedule", fontsize=16, weight='bold', color='#333333', pad=15)
plt.xlabel("Dates", fontsize=12, labelpad=10, color='gray')
plt.ylabel("Issues", fontsize=12, labelpad=10, color='gray')

# Add a legend for "Today" line
plt.legend(loc="upper right")

# Grid for readability
plt.grid(visible=True, axis='x', linestyle='--', color='gray', alpha=0.6)

# Adjust layout for a clean appearance
plt.tight_layout()

# Save the chart as an image file
plt.savefig("gantt_chart.png", format="png")
