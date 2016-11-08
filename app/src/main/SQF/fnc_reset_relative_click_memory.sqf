#include "script_component.hpp"

(ATragMX_workingMemory select ATragMX_currentTarget) set [10, 0];
(ATragMX_workingMemory select ATragMX_currentTarget) set [11, 0];

call compile preprocessFile ("\atragmx\fnc_update_result.sqf");
