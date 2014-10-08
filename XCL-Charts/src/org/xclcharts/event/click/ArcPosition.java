/**
 * Copyright 2014  XCL-Charts
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 	
 * @Project XCL-Charts 
 * @Description Android图表基类库
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 * @license http://www.apache.org/licenses/  Apache v2 License
 * @version 1.0
 */
package org.xclcharts.event.click;

import org.xclcharts.common.MathHelper;

import android.graphics.PointF;

/**
 * @ClassName ArcPosition
 * @Description  arc位置记录信息基类
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 *  
 */
public class ArcPosition extends PositionRecord {
	
	protected float mOffsetAngle = 0.0f;
	protected float mCurrentAngle = 0.0f;	
	protected float mRadius = 0.0f;
	
	protected PointF mCirXY = null;
	

	public ArcPosition()
	{	
	}
	
	
	public float getAngle()
	{
		return MathHelper.getInstance().add(mOffsetAngle , mCurrentAngle);
	}

	
	public float getRadius()
	{
		return mRadius;		
	}
	
	public PointF getPointF()
	{
		return mCirXY;
	}
	
	public float getStartAngle()
	{
		return mOffsetAngle;
	}
	
	public float getSweepAngle()
	{
		return mCurrentAngle;
	}
	
	@Override
	protected boolean compareRange(float x, float y) {
		// TODO Auto-generated method stub
		if(null == mCirXY)return false;								
		return compareRadius( x,  y) ;
	}
	
	
	private boolean compareRadius(float x, float y) 
	{		
		double distance =  MathHelper.getInstance().getDistance(mCirXY.x, mCirXY.y, x,y);		
		if(Double.compare(distance, mRadius)  == 0 || Double.compare(distance, mRadius) == -1)
		{							
			float Angle1 = (float) MathHelper.getInstance().getDegree(mCirXY.x, mCirXY.y, x,y);
			float currAngle = getAngle();
						
			if( Float.compare(currAngle, Angle1) == 1 || Float.compare(currAngle, Angle1) == 0  )
			{						
				return true;
			}						
		}		
		return false;
	}
	

	
}
