#include "script_component.hpp"

private ["_targetSize", "_imageSize", "_angle", "_estRange"];

_angle = parseNumber(ctrlText 7012);
_targetSize = parseNumber(ctrlText 7010);
if (ATragMX_rangeAssistUseTargetHeight) then
{
	_targetSize = _targetSize * cos(_angle);
};
switch (ATragMX_rangeAssistTargetSizeUnit) do
{
	case 0:
	{
		_targetSize = _targetSize * 0.0254;
	};
	case 1:
	{
		_targetSize = _targetSize * 0.3048;
	};
	case 2:
	{
		_targetSize = _targetSize * 0.01;
	};
};
_imageSize = parseNumber(ctrlText 7011);
switch (ATragMX_rangeAssistImageSizeUnit) do
{
	case 0:
	{
		_imageSize = _imageSize / 6400 * 360;
	};
	case 1:
	{
		_imageSize = _imageSize / 60;
	};
	case 2:
	{
		_imageSize = _imageSize / 60 / 1.047;
	};
};
_estRange = parseNumber(ctrlText 7013);
if (ATragMX_currentUnit != 2) then
{
	_estRange = _estRange / 1.0936133;
};

switch (_this) do
{
	case 0:
	{
		_targetSize = tan(_imageSize) * _estRange;
		
		if (ATragMX_rangeAssistUseTargetHeight) then
		{
			_targetSize = _targetSize / cos(_angle);
		};
		
		switch (ATragMX_rangeAssistTargetSizeUnit) do
		{
			case 0:
			{
				_targetSize = _targetSize / 0.0254;
			};
			case 1:
			{
				_targetSize = _targetSize / 0.3048;
			};
			case 2:
			{
				_targetSize = _targetSize / 0.01;
			};
		};
		
		ctrlSetText [7010, Str(Round(_targetSize * 100) / 100)];
	};
	case 1:
	{
		_imageSize = atan(_targetSize / _estRange);
		
		switch (ATragMX_rangeAssistImageSizeUnit) do
		{
			case 0:
			{
				_imageSize = _imageSize * 6400 / 360;
			};
			case 1:
			{
				_imageSize = _imageSize * 60;
			};
			case 2:
			{
				_imageSize = _imageSize * 60 * 1.047;
			};
		};
		
		ctrlSetText [7011, Str(Round(_imageSize * 100) / 100)];
	};
	case 2:
	{
		_estRange = _targetSize / tan(_imageSize);
		
		ctrlSetText [7013, Str(Round(_estRange))];
	};
};
