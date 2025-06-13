# Lap Completion Message Implementation Plan

## **Current System Analysis**

The current system shows "GREAT JOB!" only when all 3 laps of a race are completed. We need to modify it to show individual lap completion messages.

### Current Flow:
1. `MapTile.reactToCollisionWith()` detects finish line collision
2. Calls `gamePlayManager.roundCompleted()` 
3. Increments `currentLap` and sets `raceCompleted = true` when `currentLap > MAX_LAPS`
4. `GameManager.endOfLevel()` and `endOfGame()` both check `currentLap == MAX_LAPS`
5. Shows "GREAT JOB!" only when all laps completed

## **Implementation Plan**

### **Phase 1: Add Lap Completion Tracking to GamePlayManager**

**Files to modify:** `GamePlayManager.java`

**Changes:**
- Add new fields:
  ```java
  private boolean lapJustCompleted = false;
  private int justCompletedLapNumber = 0;
  ```

- Modify `roundCompleted()` method to set flags when individual laps complete
- Add getter methods:
  ```java
  public boolean isLapJustCompleted() { return lapJustCompleted; }
  public int getJustCompletedLapNumber() { return justCompletedLapNumber; }
  public void clearLapCompletionFlag() { lapJustCompleted = false; }
  ```

### **Phase 2: Modify GameManager Logic**

**Files to modify:** `GameManager.java`

**Changes:**
- Add new method `lapCompleted()` to check lap completion state
- Add `getLapCompletionMessage(int lapNumber)` for message generation
- Modify `gameManagement()` to handle lap completion before game end
- Update completion condition logic

**New Logic Flow:**
```java
private void gameManagement() {
    if (endOfGame()) {
        // Current end-of-game logic (unchanged)
    } else if (lapCompleted()) {
        // New lap completion handling
        if (!overlay.isMessageShown()) {
            gameView.playSound("complete.wav", false);
            overlay.showMessage(getLapCompletionMessage(getJustCompletedLapNumber()));
        }
        if (gameView.timer(2000, 0, this)) {
            overlay.stopShowing();
            clearLapCompletionFlag();
        }
    }
}
```

**Message Generation:**
```java
private String getLapCompletionMessage(int lapNumber) {
    return switch (lapNumber) {
        case 1 -> "Lap 1 Complete!";
        case 2 -> "Lap 2 Complete!";
        case 3 -> "Final Lap Complete!";
        default -> "Lap Complete!";
    };
}
```

### **Phase 3: Update Completion Logic**

**Key Changes:**
- Fix logic inconsistency where `endOfLevel()` and `endOfGame()` had identical conditions
- Update `endOfLevel()` to return false (since lap completion handled separately)
- Keep `endOfGame()` to trigger after "Final Lap Complete!" message
- Ensure proper state management between lap completion and race completion

## **Expected Behavior After Implementation**

- **Lap 1 completion:** Shows "Lap 1 Complete!" for 2 seconds, then continues race
- **Lap 2 completion:** Shows "Lap 2 Complete!" for 2 seconds, then continues race  
- **Lap 3 completion:** Shows "Final Lap Complete!" for 2 seconds, then shows current end-of-race screen

## **Implementation Flow**

```
Car hits finish line
    ↓
MapTile.reactToCollisionWith
    ↓
gamePlayManager.roundCompleted
    ↓
currentLap <= MAX_LAPS? 
    ↓ (Yes)                    ↓ (No)
Set lapJustCompleted = true    Set raceCompleted = true
Set justCompletedLapNumber         ↓
    ↓                        GameManager.endOfGame triggers
GameManager.lapCompleted           ↓
    ↓                        Show end-of-race screen
Show lap completion message
    ↓
Clear flag after timer
```

## **Files Modified**
1. `GamePlayManager.java` - Add lap completion state tracking
2. `GameManager.java` - Add lap completion message handling

## **Testing Checklist**
- [ ] Lap 1 completion shows "Lap 1 Complete!"
- [ ] Lap 2 completion shows "Lap 2 Complete!"
- [ ] Lap 3 completion shows "Final Lap Complete!" then end-of-race screen
- [ ] Sound effects play correctly
- [ ] Lap counter display updates properly
- [ ] No duplicate messages appear
- [ ] Race completion flow works correctly after final lap message